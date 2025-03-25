package ch16;


public class RepositoryService {

    public void addCustomer(String email){
        Repository.addCustomer(email);
    }
    public void addCustomer(String email,String name){
        Repository.addCustomer(email,name);
    }

    public static Customer findCustomer(String email){
        return Repository.findCustomer(email);
    }
}
