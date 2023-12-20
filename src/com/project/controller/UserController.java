package com.project.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;

public class UserController {

	private int optionUser = 0;
	Scanner s = new Scanner(System.in);
	UserService userService = new UserServiceImpl();

	// start of instance block
	{
		do {
			System.out.println("1. Select 1 Add User\n2. Select 2 Delete User\n3. Select 3 Update User"
					+ "\n4. Select 4 to Show All User\n5. Select 5 to Show Any User\n6. Select 6 for Exit");
			optionUser = s.nextInt();
			switch (optionUser) {
			case 1:
				addUser();
				break;
			case 2:
				deleteUser();
				break;
			case 3:
				updateUser();
				break;
			case 4:
				showAllUser();
				break;
			case 5:
				searchAnyUser();
				break;
			case 6:
				System.out.println("Exited from User Section Successfully...");
				break;
			}
		} while (optionUser != 6);
	}// end of instance block

	private void addUser() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter name");
			String name = br.readLine();
			System.out.println("Enter email");
			String email = br.readLine();
			System.out.println("Enter password");
			String pass = br.readLine();
			UserDTO user = new UserDTO(name, email, pass);
			boolean isUserSaved = userService.updateUser(user);
			if (isUserSaved) {
				System.out.println("Data has been saved successfully...");
			} else {
				System.out.println("Something went wrong to save data..");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void searchAnyUser() {
		try {
			System.out.println("Enter email: ");
			String email = s.next();
			UserDTO user = new UserDTO(0, null, email, null);
			UserDTO isSearched = userService.searchUser(user);
		

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void showAllUser() {
		List<UserDTO> users = userService.showAllUser();
		System.out.println("------------------User Records are------------------");
		for (UserDTO user : users) {
			System.out.println(user);
		}

	}

	private void updateUser() {
		InputStreamReader isr = null;
		BufferedReader br = null;
		try {
			isr = new InputStreamReader(System.in);
			br = new BufferedReader(isr);
			System.out.println("Enter new Id: ");
			int id = s.nextInt();
			System.out.println("Enter new name: ");
			String name = br.readLine();
			System.out.println("Enter new email: ");
			String email = br.readLine();
			System.out.println("Enter new password: ");
			String password = br.readLine();
			UserDTO user = new UserDTO(id, name, email, password);
			boolean isUserUpdated = userService.updateUser(user);

			if (isUserUpdated) {
				System.out.println("User updated successfully.");
			} else {
				System.out.println("Something went wrong!\nFailed to update user.");
			}

		} catch (Exception e) {

		}
	}

	private void deleteUser() {

		System.out.println("Enter your  email id to delete record");
		String email = s.next();
		boolean isUserDeleted = userService.deleteUser(email);
		if (isUserDeleted) {
			System.out.println("Data has been deleted successfully...");
		} else {
			System.out.println("Something went wrong to delete data..");

		}
	}

}
