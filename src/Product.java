import java.util.Objects;

class Product {
        private int id;
        private String name;
        private float price;

        public Product(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public float getPrice() {
            return price;
        }

        @Override
        public String toString() {
            return "\nProduct{ " +
                    "id = " + id +
                    ", name ='" + name + '\'' +
                    ", price = " + price +
                    "}";
        }

    }



