
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class HandleOrders {
   private static final double PIZZA_BASE_PRICE = 10.0;
   private String[] pizzasOrdered = new String[10];
   private String[] pizzaSizesOrdered = new String[10];
   private String[] sideDishesOrdered = new String[20];
   private String[] drinksOrdered = new String[20];
   private double totalOrderPrice = 0.0;
   private int numberOfPizzasOrdered = 0;
   StringBuilder pizzaOrderSummary = new StringBuilder();
   private ArrayList<CustomPizza> customPizzas = new ArrayList();
   Scanner input;

   public HandleOrders() {
      this.input = new Scanner(System.in);
   }

   public void takeOrder() {
      String orderAnother = "Y";
      int j = 0;
      int m = 0;
      int n = 0;
      int p = 0;

      do {
         int i = 1;
         System.out.println("Welcome to Slice-o-Heaven Pizzeria. Here’s what we serve: \n");
         PizzaSelection[] var10;
         int sideDishChoice = (var10 = PizzaSelection.values()).length;

         int sizeChoice;
         for(sizeChoice = 0; sizeChoice < sideDishChoice; ++sizeChoice) {
            PizzaSelection pizza = var10[sizeChoice];
            System.out.println("" + i + ". " + String.valueOf(pizza));
            ++i;
         }

         System.out.println("6. Custom Pizza with a maximum of 10 toppings that you choose: \n");
         System.out.println("Please enter your choice (1-6): \n");
         int choice = this.input.nextInt();
         this.input.nextLine();
         int l;
         String[] var10000;
         String var10002;
         int drinkChoice;
         if (choice > 0 && choice < 6) {
            switch (choice) {
               case 1:
                  System.out.println("You have selected " + String.valueOf(PizzaSelection.PEPPERONI));
                  this.pizzasOrdered[j] = PizzaSelection.PEPPERONI.toString();
                  this.totalOrderPrice += PizzaSelection.PEPPERONI.getPrice();
                  ++this.numberOfPizzasOrdered;
                  ++j;
                  break;
               case 2:
                  System.out.println("You have selected " + String.valueOf(PizzaSelection.HAWAIIAN));
                  this.pizzasOrdered[j] = PizzaSelection.HAWAIIAN.toString();
                  this.totalOrderPrice += PizzaSelection.HAWAIIAN.getPrice();
                  ++this.numberOfPizzasOrdered;
                  ++j;
                  break;
               case 3:
                  System.out.println("You have selected " + String.valueOf(PizzaSelection.VEGGIE));
                  this.pizzasOrdered[j] = PizzaSelection.VEGGIE.toString();
                  this.totalOrderPrice += PizzaSelection.VEGGIE.getPrice();
                  ++this.numberOfPizzasOrdered;
                  ++j;
                  break;
               case 4:
                  System.out.println("You have selected " + String.valueOf(PizzaSelection.BBQ_CHICKEN));
                  this.pizzasOrdered[j] = PizzaSelection.BBQ_CHICKEN.toString();
                  this.totalOrderPrice += PizzaSelection.BBQ_CHICKEN.getPrice();
                  ++this.numberOfPizzasOrdered;
                  ++j;
                  break;
               case 5:
                  System.out.println("You have selected " + String.valueOf(PizzaSelection.EXTRAVAGANZA));
                  this.pizzasOrdered[j] = PizzaSelection.EXTRAVAGANZA.toString();
                  this.totalOrderPrice += PizzaSelection.EXTRAVAGANZA.getPrice();
                  ++this.numberOfPizzasOrdered;
                  ++j;
                  break;
               default:
                  System.out.println("Incorrect choice. Please try again.");
            }
         } else if (choice == 6) {
            double customPizzaPrice = 0.0;
            System.out.println("For your custom pizza, here are the toppings:");
            drinkChoice = 1;
            PizzaToppings[] var14;
            int toppingChoice = (var14 = PizzaToppings.values()).length;

            for(l = 0; l < toppingChoice; ++l) {
               PizzaToppings topping = var14[l];
               System.out.println("" + drinkChoice + ". " + String.valueOf(topping));
               ++drinkChoice;
            }

            System.out.println("Please enter a maximum of 10 topping choices.\n");
            StringBuilder customPizzaToppings = new StringBuilder();
            l = 1;

            do {
               System.out.println("Enter topping #" + l + ". To stop, type 0: ");
               toppingChoice = this.input.nextInt();
               this.input.nextLine();
               if (toppingChoice == 0) {
                  break;
               }

               String var10001 = PizzaToppings.values()[toppingChoice - 1].getTopping();
               customPizzaToppings.append(var10001 + ", ");
               customPizzaPrice += PizzaToppings.values()[toppingChoice - 1].getToppingPrice();
               ++l;
            } while(l <= 10);

            if (customPizzaToppings.length() > 0) {
               customPizzaToppings.delete(customPizzaToppings.length() - 2, customPizzaToppings.length());
            }

            customPizzaPrice += 10.0;
            CustomPizza customPizza = new CustomPizza(customPizzaToppings.toString(), customPizzaPrice);
            this.customPizzas.add(customPizza);
            var10000 = this.pizzasOrdered;
            var10002 = customPizzaToppings.toString();
            var10000[j] = "Custom Pizza with " + var10002 + ": €" + customPizzaPrice;
            this.totalOrderPrice += customPizzaPrice;
            ++this.numberOfPizzasOrdered;
            ++j;
         }

         i = 1;
         System.out.println("Here are the pizza sizes options: \n");
         PizzaSize[] var21;
         drinkChoice = (var21 = PizzaSize.values()).length;

         for(sideDishChoice = 0; sideDishChoice < drinkChoice; ++sideDishChoice) {
            PizzaSize pizza = var21[sideDishChoice];
            System.out.println("" + i + ". " + String.valueOf(pizza));
            ++i;
         }

         System.out.println("Pick one size (1 - 3): \n");
         sizeChoice = this.input.nextInt();
         this.input.nextLine();
         var10000 = this.pizzaSizesOrdered;
         var10002 = PizzaSize.values()[sizeChoice - 1].getPizzaSize();
         var10000[m] = var10002 + ": €" + PizzaSize.values()[sizeChoice - 1].getAddToPizzaPrice();
         this.totalOrderPrice += PizzaSize.values()[sizeChoice - 1].getAddToPizzaPrice();
         ++m;
         System.out.println("Here are the side dishes options: \n");
         i = 1;
         SideDish[] var24;
         int var22 = (var24 = SideDish.values()).length;

         for(drinkChoice = 0; drinkChoice < var22; ++drinkChoice) {
            SideDish sideDish = var24[drinkChoice];
            System.out.println("" + i + ". " + String.valueOf(sideDish));
            ++i;
         }

         System.out.println("Pick one side dish (1 - 4): \n");
         sideDishChoice = this.input.nextInt();
         this.input.nextLine();
         var10000 = this.sideDishesOrdered;
         var10002 = SideDish.values()[sideDishChoice - 1].getSideDishName();
         var10000[n] = var10002 + ": €" + SideDish.values()[sideDishChoice - 1].getAddToPizzaPrice();
         this.totalOrderPrice += SideDish.values()[sideDishChoice - 1].getAddToPizzaPrice();
         ++n;
         System.out.println("Here are the drinks options: \n");
         i = 1;
         Drinks[] var26;
         l = (var26 = Drinks.values()).length;

         for(var22 = 0; var22 < l; ++var22) {
            Drinks drink = var26[var22];
            System.out.println("" + i + ". " + String.valueOf(drink));
            ++i;
         }

         System.out.println("Pick one drink (1 - 3): \n");
         drinkChoice = this.input.nextInt();
         this.input.nextLine();
         var10000 = this.drinksOrdered;
         var10002 = Drinks.values()[drinkChoice - 1].getDrinkName();
         var10000[p] = var10002 + ": €" + Drinks.values()[drinkChoice - 1].getAddToPizzaPrice();
         this.totalOrderPrice += Drinks.values()[drinkChoice - 1].getAddToPizzaPrice();
         ++p;
         System.out.println("Would you like to order another pizza? (Y/N): \n");
         orderAnother = this.input.nextLine();
      } while(orderAnother.equalsIgnoreCase("Y"));

   }

   public void createOrderSummary() {
      this.pizzaOrderSummary.append("\nThank you for dining with Slice-o-Heaven. Your order details are as follows: \n");

      for(int i = 0; i < this.numberOfPizzasOrdered; ++i) {
         this.pizzaOrderSummary.append(i + 1 + ". " + this.pizzasOrdered[i] + "\n");
         String var10001 = this.pizzaSizesOrdered[i];
         this.pizzaOrderSummary.append("    " + var10001 + "\n");
         var10001 = this.sideDishesOrdered[i];
         this.pizzaOrderSummary.append("    " + var10001 + "\n");
         var10001 = this.drinksOrdered[i];
         this.pizzaOrderSummary.append("    " + var10001 + "\n \n");
      }

      this.pizzaOrderSummary.append("ORDER TOTAL: €" + this.totalOrderPrice + "\n");
   }

   public void displayCustomPizzas() {
      Iterator var2 = this.customPizzas.iterator();

      while(var2.hasNext()) {
         CustomPizza pizza = (CustomPizza)var2.next();
         System.out.println(pizza);
      }

   }

   public String toString() {
      return this.pizzaOrderSummary.toString();
   }

   public static void main(String[] args) {
      HandleOrders handleOrders = new HandleOrders();
      handleOrders.takeOrder();
      handleOrders.createOrderSummary();
      System.out.println(handleOrders);
      handleOrders.displayCustomPizzas();
   }
}