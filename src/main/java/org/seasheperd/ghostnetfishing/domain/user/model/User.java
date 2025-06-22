package org.seasheperd.ghostnetfishing.domain.user.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
  private long id;
  private String vorname;
  private String nachname;
  private String telefonnr;
  private String password;

  public User(String vorname, String nachname, String telefonnr) {
    this.id = 0;
    this.vorname = vorname;
    this.nachname = nachname;
    this.telefonnr = telefonnr;
  }
}
