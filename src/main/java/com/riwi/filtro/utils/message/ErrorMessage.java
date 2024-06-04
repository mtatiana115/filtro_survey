package com.riwi.filtro.utils.message;

public class ErrorMessage {

  public static String idNotFound (String entity) {
    final String message = "There are no resgister in %s with that id";
    return String.format(message, entity);
  }

}
