public class CodeContent {
    public String type;
    public Step[] steps;
    public String version;
    public Order order;
    public Setting setting;




}

 class Step {
     public String stepType;
     public Parameter parameter;
     public String name;
     public String category;
}

class Parameter{
    public String datasource;
    public String[] column;
    public String beginDateTime;
    public Long batchSize;
    public String encoding;
    public String endDateTime;
    public String fieldDelimiter;
    public String logstore;
    public String partition;
    public Boolean truncate;
    public Boolean emptyAsNull;
    public String table;
}

class Order{
    public Hop[] hops;
}

class Hop{
    public String from;
    public String to;
}

class Setting{
    public ErrorLimit errorLimit;
    public Speed speed;
}

class ErrorLimit{
    public String record;

}

class Speed{
    public boolean throttle;
    public long concurrent;
}