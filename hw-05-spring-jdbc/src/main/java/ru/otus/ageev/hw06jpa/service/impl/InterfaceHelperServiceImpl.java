package ru.otus.ageev.hw06jpa.service.impl;

import org.springframework.stereotype.Service;
import ru.otus.ageev.hw06jpa.domain.Author;
import ru.otus.ageev.hw06jpa.service.InterfaceHelperService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
public class InterfaceHelperServiceImpl implements InterfaceHelperService {

    @Override
    public List<Author> addAuthors() {
        List<Author> authorList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Please add author(s): ");
        while (true) {
            Author newAuthor = addAuthor();
            authorList.add(newAuthor);
            System.out.println("If list filled type \"stop\" if you need add one more press enter: ");
            String t = sc.nextLine();
            if ("stop".equals(t)) {
                break;
            }
        }
        return authorList;
    }

    private Author addAuthor() {
        System.out.println("Insert Name of author: ");
        String name = new Scanner(System.in).nextLine();
        System.out.println("Insert Family name of author: ");
        String surname = new Scanner(System.in).nextLine();
        return new Author(null, name, surname);
    }
}
