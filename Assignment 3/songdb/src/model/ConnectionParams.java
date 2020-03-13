package model;


public class ConnectionParams {
    private String username;
    private String host;
    private String password;
    private int port;
    private String dbName;

    public ConnectionParams(String host, int port, String username, String password, String dbName) {
        this.username = username;
        this.host = host;
        this.dbName = dbName;
        this.password = password;
        this.port = port;
    }
}
