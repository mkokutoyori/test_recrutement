import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        /***
         * Déclarons mes possessions
         */
        var possession=List.of("bike","driving license");
        /**
         * Declarons les Company
         */
        var a=new Company("A",new Requirement("apartment","house"),new Requirement("property insurance"));
        var b=new Company("B",new Requirement("5 door car","4 door car"),new Requirement("driving license"),new Requirement("car insurance"));
        var c=new Company("C",new Requirement("social security number"),new Requirement("work permit"));
        var d=new Company("D",new Requirement("apartment","flat","house"));
        var e=new Company("E",new Requirement("driving license"),new Requirement("3 door car","4 door car","5 door car"));
        var f=new Company("F",new Requirement("scooter","bike","motorcycle"),new Requirement("driving license"),new Requirement("motorcycle insurance"));
        var g=new Company("G",new Requirement("massage qualification certificate"),new Requirement("liability insurance"));
        var h=new Company("H",new Requirement("storage place","garage"));
        var j=new Company("J");
        var k=new Company("K",new Requirement("PayPal account"));
        
        var listofCompany=List.of(a,b,c,d,e,f,g,h,j,k);
        System.out.println("Here is the list of the company where you can work");
        listofCompany.stream().filter(company -> company.canWorkThere(possession)).forEach(company -> System.out.println(company.getName()));
    }

}

class Company{

    private List<Requirement> requirements=new ArrayList<>();
    private String name;

    public boolean canWorkThere(List<String> possession){
        boolean b = requirements.stream().allMatch(requirement -> requirement.meetRequirement(possession));
        return b;
    }
    public Company(String name,Requirement... requirements){
        this.name=name;
        this.requirements.addAll(List.of(requirements));
    }

    public String getName() {
        return name;
    }
}

class Requirement {
    private List<String> labels=new ArrayList<>();

    public Requirement(String... labels){
       this.labels.addAll(List.of(labels));
    }

    public boolean meetRequirement(List<String> possession){;
        boolean b = labels.stream().anyMatch(s -> possession.contains(s));
        return b;
    }
}