package edu.miu.post.Runner;

import edu.miu.post.Domain.Roles;
import edu.miu.post.Domain.User;
import edu.miu.post.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DBOperationRunner implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public void run(String... args) throws Exception {

        User admin = new User();
        admin.setFirstName("Meresa");
        admin.setLastName("Gebrewahd");
        admin.setUserName("Mera G");
        admin.setEmail("meresa27@gmail.com");
        admin.setPassword(passwordEncoder.encode("123456"));
        admin.setRoles(Roles.ADMIN);

        User normal = new User();
        normal.setFirstName("Yemane");
        normal.setLastName("Yohans");
        normal.setUserName("Yemane Y");
        normal.setEmail("yeme21@gmail.com");
        normal.setPassword(passwordEncoder.encode("123yeme"));
        normal.setRoles(Roles.User);

        userRepo.saveAll(Arrays.asList(admin, normal));


    }
}
