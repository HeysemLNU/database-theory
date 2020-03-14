package model;


import com.mysql.cj.x.protobuf.MysqlxDatatypes;

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

    public void setUsername(String username) {
        this.username = username;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUsername() {
        return username;
    }

    public String getHost() {
        return host;
    }

    public String getPassword() {
        return password;
    }

    public int getPort() {
        return port;
    }

    public String getDbName() {
        return dbName;
    }

    public String getNoCreds() {
        StringBuilder sb = new StringBuilder();
        sb.append("jdbc:mysql://");
        sb.append(this.host);
        sb.append(":");
        sb.append(this.port);
        sb.append("/");
        sb.append(this.dbName);
        return sb.toString();
    }
}
