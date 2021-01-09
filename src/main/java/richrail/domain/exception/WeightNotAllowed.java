package richrail.domain.exception;

public class WeightNotAllowed extends RuntimeException {
    private String message;

    public WeightNotAllowed(){
        this.message = "Weight not supported";
    }

    public WeightNotAllowed(String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
