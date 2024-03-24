package org.example.bankapi.DTO;

import lombok.Data;

@Data
public class RegisterDTO {

        private String email;
        private String password;
        private String role;
}
