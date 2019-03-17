
public class test {
        public static void main(String agrs[]) {
                System.out.println("magic");
                test.interning_behaviour("12");
        }

        public static void interning_behaviour(String string_input)     {
                String string="12";
                String string_5;
                string_5=string_input.substring(0);
                System.out.println(string==string_5);
                
        }

}
