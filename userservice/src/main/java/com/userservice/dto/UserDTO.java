package com.userservice.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
    @NotNull(message = "nic is null")
    @NotBlank(message = "nic is null")
    @Pattern(regexp = "^\\d{9}V$", message = "invalid nic format")
    private String nic;
    @NotNull(message = "username is null")
    @NotBlank(message = "username is null")
    private String userName;
    @NotNull(message = "address is null")
    @NotBlank(message = "address is null")
    private String address;
}
