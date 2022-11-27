public class DBConnectionSingleton {
    public static final DBConnectionSingleton INSTANCE = new DBConnectionSingleton();

    private DBConnectionSingleton() {
        // intialize db singleton
    }

    public void connectToDB() {
        System.out.println("connected to db");
    }
}