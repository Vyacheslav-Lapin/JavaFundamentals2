package generics;

import java.util.ArrayList;
import java.util.List;

public class MedicalStaff extends Object {

    public static void main(String[] args) {

//        List<? extends generics.Doctor> list1 = new ArrayList<generics.MedicalStaff>(); // error
        List<? extends Doctor> list2 = new ArrayList<>();
        List<? extends Doctor> list3 = new ArrayList<HeadDoctor>();

//        List<? super generics.Doctor> list7 = new ArrayList<generics.HeadDoctor>(); // error
        List<? super Doctor> list6 = new ArrayList<MedicalStaff>();
        List<? super Doctor> list5 = new ArrayList<Object>();
        List<Doctor> list4 = new ArrayList<>();

//        list5.add(new Object()); // error
//        list5.add(new generics.MedicalStaff()); // error
//        list6.add(new generics.MedicalStaff());
        list5.add(new Doctor());
        list5.add(new HeadDoctor());

//        final generics.Doctor object = list6.get(1);
//        System.out.println(object);
    }

}

class Doctor extends MedicalStaff {}
class HeadDoctor extends Doctor {}
class Nurse extends MedicalStaff {}