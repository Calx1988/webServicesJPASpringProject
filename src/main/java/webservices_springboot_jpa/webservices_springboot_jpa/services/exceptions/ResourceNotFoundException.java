package webservices_springboot_jpa.webservices_springboot_jpa.services.exceptions;

public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(Object id){
        super("Resource not found. ID: "+ id);
    }

}
