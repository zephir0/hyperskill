class ManufacturingController {
    private static int counter = 0;


    public static String requestProduct(String product) {
        counter ++;
        return counter + ". Requested " + product;
    }

    public static int getNumberOfProducts() {
        return counter;
    }
}

