package jdbcdemo.jdbcdemo;

import java.util.List;

import domain.Person;
import jdbcdemo.dao.PersonRepository;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	PersonRepository repository = new PersonRepository();
    	repository.createTable();
    	
    	Person janek = new Person();
    	janek.setName("Jan");
    	janek.setSurname("Kowalski");
    	janek.setAge(30);
    	
    	repository.add(janek);
    	
    	List<Person> people = repository.getAll();
    	
    	for(Person p : people){
    		System.out.println(p.getId()+"\t"+p.getName()+"\t"+p.getSurname()+"\t"+p.getAge());
    	}
    	
        System.out.println( "Koniec" );
    }
}
