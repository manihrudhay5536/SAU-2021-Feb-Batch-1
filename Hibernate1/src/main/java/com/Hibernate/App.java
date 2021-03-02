package com.Hibernate;
import com.Hibernate.util.Util;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.*;




public class App {

    public  static  void main(String args[]) {

        ChoiceMenu choice = new ChoiceMenu();
        Session session = Util.getSession();
        Transaction tx = session.beginTransaction();
        Scanner sc = new Scanner(System.in);
        choice.printChoice();
        int ip;
     do {
         ip = sc.nextInt();
         switch (ip) {
             case 1:
                 System.out.println("\n\n");
                 Employee addEmployee = choice.getDetails();
                 if (Objects.isNull(addEmployee))
                     break;
                 else {
                     session.save(addEmployee);
                     System.out.println("**********EMPLOYEE ADDED*************");
                     tx.commit();
                 }
                 System.out.println("\n\n");
                 break;
             default:
                 System.out.println("Invalid Input");
             case 2:
                 System.out.println("Enter Employee Id whose details are to be updated");
                 int currentID = sc.nextInt();
                 System.out.println("Enter the attribute to update:\n" +
                         "1- Employee ID\n" +
                         "2- First Name\n" +
                         "3- Last Name\n" +
                         "4- Age\n" +
                         "5- Designation\n" +
                         "6- Date of Birth\n" +
                         "7- Salary");
                 int attribute = sc.nextInt();
                 switch (attribute) {
                     case 1:
                         System.out.println("Enter New ID");
                         int updatedID = sc.nextInt();
                         sc.nextLine();

                         String sqlquery = String.format("Update emp SET id ='%d' where id ='%d';", updatedID, currentID);
                         try {
                             session.createSQLQuery(sqlquery).executeUpdate();
                             System.out.println("Employee ID successfully updated !");
                             tx.commit();
                         } catch (Exception e2) {
                             System.out.println("Enter the correct Employee ID");
                         }
                         break;


                     case 2:
                         System.out.println("Enter the updated First Name");
                         String updatedFname = sc.next();
                         sqlquery = String.format("Update emp SET firstName ='%s' where id ='%d';", updatedFname, currentID);
                         try {
                             session.createSQLQuery(sqlquery).executeUpdate();
                             System.out.println("First Name of employee with ID = " + currentID + "Updated");
                             tx.commit();
                         } catch (Exception e2) {
                             System.out.println("Enter the correct Employee ID");
                         }
                         break;


                     case 3:
                         System.out.println("Enter the updated Last Name");
                         String updatedLname = sc.next();
                         sqlquery = String.format("Update emp SET lastName ='%s' where id ='%d';", updatedLname, currentID);
                         try {
                             session.createSQLQuery(sqlquery).executeUpdate();
                             System.out.println("Last Name of employee with ID = " + currentID + "Updated");
                             tx.commit();
                         } catch (Exception e2) {
                             System.out.println("Enter the correct Employee ID");
                         }
                         break;

                     case 4:
                         System.out.println("Enter the updated Age of Employee ");
                         int updatedAge = sc.nextInt();
                         sqlquery = String.format("Update emp SET age ='%s' where id ='%d';", updatedAge, currentID);
                         try {
                             session.createSQLQuery(sqlquery).executeUpdate();
                             System.out.println("Age of employee with ID = " + currentID + "Updated");
                             tx.commit();
                         } catch (Exception e2) {
                             System.out.println("Enter the correct Employee ID");
                         }
                         break;

                     case 5:
                         System.out.println("Enter the updated Designation of Employee ");
                         String updatedDesignation = sc.next();
                         sqlquery = String.format("Update emp SET designation ='%s' where id ='%d';", updatedDesignation, currentID);
                         try {
                             session.createSQLQuery(sqlquery).executeUpdate();
                             System.out.println("Designation of employee with ID = " + currentID + "Updated");
                             tx.commit();
                         } catch (Exception e2) {
                             System.out.println("Enter the correct Employee ID");
                         }
                         break;


                     case 6:
                         System.out.println("Enter the updated DOB of Employee ");
                         String updatedDOB = sc.next();
                         sqlquery = String.format("Update emp SET dob ='%s' where id ='%d';", updatedDOB, currentID);
                         try {
                             session.createSQLQuery(sqlquery).executeUpdate();
                             System.out.println("DOB of employee with ID = " + currentID + "Updated");
                             tx.commit();
                         } catch (Exception e2) {
                             System.out.println("Enter the correct Employee ID");
                         }
                         break;

                     case 7:
                         System.out.println("Enter the updated Salary of Employee ");
                         int updatedSalary = sc.nextInt();
                         sqlquery = String.format("Update emp SET sal ='%s' where id ='%d';", updatedSalary, currentID);
                         try {
                             session.createSQLQuery(sqlquery).executeUpdate();
                             System.out.println("Salary of employee with ID = " + currentID + "Updated");
                             tx.commit();
                         } catch (Exception e2) {
                             System.out.println("Enter the correct Employee ID");
                         }
                         break;
                 }
             case 3:
                 System.out.println("Enter the Emplyee ID of the Employee whose records are to be delete");
                 int ide = sc.nextInt();
                 String quer = String.format("Delete from Employee where id ='%d';", ide);
                 try {
                     session.createSQLQuery(quer).executeUpdate();
                     System.out.println(" record is deleted !");
                     tx.commit();
                 } catch (Exception e2) {
                     System.out.println("Employee Not Found!");
                 }
                 break;
             case 4:
                 System.out.println("\n\n");
                 try {
                     CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
                     CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);
                     Root<Employee> root = criteriaQuery.from(Employee.class);
                     criteriaQuery.select(root);
                     Query<Employee> query = session.createQuery(criteriaQuery);
                     List<Employee> EmployeeList = query.getResultList();
                     System.out.println("------------Printing All Results---------");
                     for (int i = 0; i < EmployeeList.size(); i++) {
                         System.out.println("Emloyee: " + (i + 1));
                         Employee temp = (Employee) EmployeeList.get(i);
                         System.out.println(temp.toString());
                     }
                     System.out.println("\n\n");

                 } catch (Exception e2) {
                     System.out.println("Employee Not Found!");
                 }
                 break;
             case 5:
                 System.out.println("Enter id of employee to fetch details");
                 int num = sc.nextInt();
                 Employee p1 = session.load(Employee.class, num);
                 System.out.println(p1.getAge());
                 System.out.println(p1.getFname());
                 System.out.println(p1.getLname());
                 System.out.println(p1.getDesignation());
                 System.out.println(p1.getDob());
                 System.out.println(p1.getId());
                 System.out.println(p1.getSalary());
                 break;
             case 6:
                 System.exit(0);
         }
     }while(ip!=6);

    }
}
