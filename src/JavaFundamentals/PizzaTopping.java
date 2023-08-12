package JavaFundamentals;

public class PizzaTopping {
    private Integer id;
    private String topping;
    private Integer pizzaBaseId;

    public PizzaTopping() {
    }

    public PizzaTopping(Integer id, String topping, Integer pizzaBaseId) {
        this.id = id;
        this.topping = topping;
        this.pizzaBaseId = pizzaBaseId;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("PizzaTopping{");
        sb.append("id=").append(id);
        sb.append(", topping='").append(topping).append('\'');
        sb.append(", pizzaBaseId=").append(pizzaBaseId);
        sb.append('}');
        return sb.toString();
    }
}
