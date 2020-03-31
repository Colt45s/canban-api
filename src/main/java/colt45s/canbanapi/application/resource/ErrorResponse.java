package colt45s.canbanapi.application.resource;

import java.util.Arrays;
import java.util.List;

public class ErrorResponse {
  private String message;
  private List<String> details;

  public ErrorResponse(String message, List<String> details) {
    super();
    this.message = message;
    this.details = details;
  }

  public ErrorResponse(String message, String detail) {
    super();
    this.message = message;
    this.details = Arrays.asList(detail);
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<String> getDetails() {
    return details;
  }

  public void setDetails(List<String> details) {
    this.details = details;
  }

}