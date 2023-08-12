package JavaFundamentals;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class AsyncProgramming implements Demo {
    
    private static Logger log = LoggerFactory.getLogger(AsyncProgramming.class);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        runnableExample();
//        executor();
//        completableFuture();
//        pizzaExample();
//        getUserFeeds("sample.com");
        Future<String> res = calculateAsync();
        System.out.println(res.get());
    }

    private static void pizzaExample() {
        PizzaClient pizzaBaseClient = new PizzaClient();
        //get pizza bases
        Supplier<List<PizzaBase>> supplier = () -> pizzaBaseClient.getPizzaBases();
        
        //LOG that we have got pizza bases
        CompletableFuture<List<PizzaBase>> pizzaBasesFuture = CompletableFuture.supplyAsync(supplier);
        pizzaBasesFuture.thenRunAsync(() -> System.out.println("We have got all the pizza bases"));
        
        //map pizza bases to pizza ids
        CompletableFuture<List<Integer>> pizzaIdsFuture = pizzaBasesFuture.thenApply(pizzaBases -> pizzaBases.stream().map(PizzaBase::getId).collect(Collectors.toList()));
        
        //LOG pizza ids
        pizzaIdsFuture.thenAccept(pizzaIds-> System.out.println(pizzaIds));
        
        //TODO : understand thenCompose method
    }

    private static void completableFuture() {
        //runnable doesn't return any output
        //runAsync -  takes runnable as input, completable future values will be null
        Runnable myTask = getRunnable();
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(myTask);
        
        //supplier similar to callable 1. returns object as output 2. doesn't throw checked exceptions
        //supplyAsync -  takes supplier as input, completable future values will be present
        Supplier<String> supplier = getSupplierString();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(supplier,executor);
        
        // join similar to get in future 1. Blocking 2. checked exceptions are not thrown
        System.out.println(stringCompletableFuture.join());

        CompletableFuture.allOf(completableFuture,stringCompletableFuture).join();
        System.out.println("all done");

        // alternative value if future call is not completed temp. value only 
        System.out.println(stringCompletableFuture.getNow("use this supplier value instead"));
//        
        //exceptionally catches exception, we are returning default value for exception
        CompletableFuture<Object> exceptionCheck = CompletableFuture.supplyAsync(() -> {
            throw new RuntimeException("hey some error occurred. please fix");}).exceptionally(t->"handling exception");

        exceptionCheck.thenAccept(name-> System.out.println(name));
    }

    private static void executor() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        //execute callable
        Callable<String> callable = getCallableString();
        Future<String> future = executorService.submit(callable);
        try {
            /**
             * future.get() is a blocking call , till we don't result from future executor service it will wait
             * only we will move to next methods getRunnable() at line 25
             * 
             * Add a very high delay (iterating in loop) in callable method to test out the above scenario
             * 
             * if we don't use future.get() then it will directly jump to runnable method (no blocking) and statements inside 
             * runnable will get printed even before the loop in callable is over
             */
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        //execute runnable
        Runnable runnable = getRunnable();
        executorService.submit(runnable);
        //shutdown executor service, wait for submitted tasks to complete
        executorService.shutdown();
    }

    private static Callable<String> getCallableString() {
        Callable<String> callable = new Callable() {
            @Override
            public String call() throws Exception {
                for (int i=0;i<1000;i++){
                    System.out.println("we are in loop : "+i);
                    continue;
                }
                return "Hello callable";
            }
        };

        //using lambda expression
        Callable<String> callableV2 = (Callable) () -> "Hello callable";
        return callable;
    }

    private static Supplier<String> getSupplierString() {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
//                for (int i = 0; i < 1000; i++) {
//                    System.out.println("in supplier method "+i + " "+ Thread.currentThread().getName());
//                    continue;
//                }
                return "Hello supplier";
            }
        };
        
        //lambda expression
        Supplier<String> supplierV2 = () -> "Hello callable";
        return supplier;
    }
    
    private static Runnable getRunnable() {
        return () -> System.out.println("We are in runnable :- Executing task in thread : " + Thread.currentThread().getName());
    }

    private static void runnableExample() {
        /**
         * Creating runnable instance standard way
         Runnable runnable = new Runnable() {
        @Override public void run() {
        System.out.println("testing out runnable");
        }
        };
         **/
        for (int i = 0; i < 10; i++) {
            Thread old = Thread.currentThread();
            System.out.println(old.getName());
            Thread thread = new Thread(new Runnable() {
                //implementing method using anonymous class
                @Override
                public void run() {
                    System.out.println("testing out runnable");
                }
            });
            thread.start();
            System.out.println(thread.getName());
            Thread threadGroup = Thread.currentThread();

            // getting the total active count of the threads
            int threadCount = Thread.activeCount();

            Thread[] threadList = new Thread[threadCount];
            // enumerating over the thread list
            Thread.enumerate(threadList);
        }

        for (int i = 0; i < 10; i++) {
            //replaced with lambda expression
            Thread thread = new Thread(() -> System.out.println("testing out runnable"));
            thread.start();
            System.out.println(thread.getName());
        }

        for (int i = 0; i < 10; i++) {
            Demo demo = new AsyncProgramming() {
                @Override
                public void method1() {
                    System.out.println("override method 1");
                }
            };
            demo.method1();

        }

        Demo demo = new AsyncProgramming();
        demo.method1();
    }

    @Override
    public void method1() {
        System.out.println("method 1");
    }


    public static String getUserFeeds(String emailId) throws ExecutionException, InterruptedException {

        log.error("In method getUserFeeds() : START");

        CompletableFuture<String> loadUsersFacebookFeedsFuture = loadUsersFacebookFeeds(emailId);
        CompletableFuture<String> loadUsersGitHubFeedsFuture = loadUsersGitHubFeeds(emailId);
        CompletableFuture<String> loadUsersMediumFeedsFuture = loadUsersMediumFeeds(emailId);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                loadUsersFacebookFeedsFuture,
                loadUsersGitHubFeedsFuture,
                loadUsersMediumFeedsFuture
        );
        log.error("CALL allFutures.get() : START");

        allFutures.get();
        log.error("CALL allFutures.get() : END");

        String result = "";
        if (allFutures.isDone ()) {
            result = "User feed : "+loadUsersFacebookFeedsFuture.get()+". "+loadUsersGitHubFeedsFuture.get()+". "+loadUsersMediumFeedsFuture.get();
        } else {
            result = "Futures are not ready YET";
        }

        log.error("Result : "+result);

        return result;
    }

    static CompletableFuture<String> loadUsersFacebookFeeds(String emailId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.error("loadUsersFacebookFeeds() : START");
                TimeUnit.SECONDS.sleep(15);
                log.error("loadUsersFacebookFeeds() : END");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "This is users github details";
        });
    }

    static CompletableFuture<String> loadUsersGitHubFeeds(String emailId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.error("loadUsersGitHubFeeds() : START");
                TimeUnit.SECONDS.sleep(10);
                log.error("loadUsersGitHubFeeds() : END");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "This is users github details";
        });
    }

    static CompletableFuture<String> loadUsersMediumFeeds(String emailId) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.error("loadUsersMediumFeeds() : START");
                TimeUnit.SECONDS.sleep(5);
                log.error("loadUsersMediumFeeds() : END");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "This is users medium details";
        });
    }

    public static Future<String> calculateAsync() throws InterruptedException {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(new Callable<Object>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(500);
                System.out.println(completableFuture.complete("Hello"));
                return "nope";
            }
        });

        return completableFuture;
    }
}
