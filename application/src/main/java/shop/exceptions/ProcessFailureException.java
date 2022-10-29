package shop.exceptions;


import lombok.AllArgsConstructor;

/**
 * Process Failure Exceptions Class
 */
@AllArgsConstructor
public class ProcessFailureException extends RuntimeException{

    /**
     * Method to create process failure exception
     *
     * @param detail String
     */
    public ProcessFailureException(String detail){
        super("Error caused while trying to get the next detail: " + detail);
    }
}
