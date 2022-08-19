package storage;


import exception.AuthorNotFoundException;
import model.User;


public class UserStorage {


    private User[] array = new User[10];
    private int size = -1;

    public void add(User user) {
        if (size == array.length) {
            extend();
        }
        array[++size] = user;
    }


    public void printAllUsers() {
        for (int i = 0; i < size + 1; i++) {
            System.out.println(array[i].getName() + " " + array[i].getSurname());
        }
    }


    private void extend() {
        User[] temp = new User[array.length + 10];
        System.arraycopy(array, 0, temp, 0, size);
        array = temp;
    }

    public int getSize() {
        return size;
    }

    public UserStorage getUserByIndex(int index) throws AuthorNotFoundException {
        if (index < 0 || index >= size) {
            throw new AuthorNotFoundException("There is no UserStorage at" + index + "index");
        }
        return array[index];
    }

    public User getUserByemail(String email) {
        for (int i = 0; i <= size; i++) {
            if (array[i].getEmail().equals(email)) {
                return array[i];
            }
        }
        return null;
    }

}
