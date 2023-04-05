package net.spring.coding.service;

import net.spring.coding.model.Employee;
import net.spring.coding.repository.EmployeeRepository;
import net.spring.coding.sesstion.HibernateSesstion;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class EmployeeService implements EmployeeRepository<Employee> {

    private static Session session;
    private static Transaction transaction;
    private static HibernateSesstion hibernateSesstion;

  /*private final String READ = "select * from contact ;";*/

    public EmployeeService() {

        hibernateSesstion = new HibernateSesstion();

    }

/*      @Override
        public List<Object[]> read() {

            List<Object[]> rows = null;

            try {

                session = hibernateSesstion.getSesstion();
                SQLQuery query = session.createSQLQuery(this.READ);

                rows = query.list(); //store all info database


        } catch (Exception mess) {

            System.out.println("somethings is wrong..."+mess);

        } finally { // last working

            try {

                if(session != null) {
                    session.close();
                }

            } catch(Exception mess) {

                System.out.println("somethings is wrong..."+mess);

            }

            return rows;
        }
    }
*/
    @Override
    public Employee create(Employee object) {

    try {
        session = hibernateSesstion.getSesstion(); /** Create session factory object */
        transaction = session.beginTransaction(); /** Getting transaction object from session object */

        session.save(object); /* this save() method for insert */

        transaction.commit();
    } catch (Exception mess) {

        System.out.println("somethings is wrong..."+mess);

    } finally {

        try {

            if(session != null) {
                session.close();
            }

        } catch(Exception mess) {

            System.out.println("somethings is wrong..."+mess);

        }

    } /* finally */
    return object;
} /* end create */
    @Override
    public List<Employee> read() {

        List<Employee> employeesList = null;

        try {
            session = hibernateSesstion.getSesstion(); /** Create session factory object */
            transaction = session.beginTransaction(); /** Getting transaction object from session object */
            Query query = session.createQuery("from Employee"); /** อ้างอิงค์จาก Model Class query all table */
            employeesList = query.list(); /* then store to array list */

            } catch (Exception mess) {

            System.out.println("somethings is wrong..."+mess);

        } finally {
            try {
                if(session != null) {

                    session.close();

                }
            } catch(Exception mess) {

                System.out.println("somethings is wrong..."+mess);

            }
        }
        return employeesList;
    }
    @Override
    public Employee readById(Long id) {
        Employee employee = null;
        try {

            session = hibernateSesstion.getSesstion(); /** Create session factory object */
            transaction = session.beginTransaction(); /** Getting transaction object from session object */
            employee = session.get(Employee.class , id); /* method get() for retrieve info */

        } catch (Exception mess) {

            System.out.println("somethings is wrong..."+mess);

        } finally {

            try {
                if(session != null) {

                    session.close();

                }
            } catch(Exception mess) {

                System.out.println("somethings is wrong..."+mess);

            }
        } /* finally */
        return employee;
    } /* end read by id */
    @Override
    public void update(Employee object , Long id) {

        Employee employee;

        try {

            session = hibernateSesstion.getSesstion(); /** Create session factory object */
            transaction = session.beginTransaction(); /** Getting transaction object from session object */

            employee = session.get(Employee.class , id);
            /* add value to Model */
            employee.setName(object.getName());
            employee.setEmail(object.getEmail());
            employee.setPhone(object.getPhone());
            employee.setCity(object.getCity());
            employee.setPosition(object.getPosition());
            /* then get Model into method save() for update */
            session.save(employee); /* method for update */
            System.out.println("update successfully");
            transaction.commit();

        } catch (NullPointerException mess) {

            System.out.println("The value if you need is null "+mess);

        } finally {

            try {

                if(session != null) {
                    session.close();
                }

            } catch(Exception mess) {

                System.out.println("somethings is wrong..."+mess);

            }

        } /* finally */
    } /* end update */
    @Override
    public void delete(Long id) {

        Employee employee;
        try {
            session = hibernateSesstion.getSesstion(); /** Create session factory object */
            transaction = session.beginTransaction(); /** Getting transaction object from session object */

            employee = session.get(Employee.class , id);

            session.delete(employee); /* method for delete */
            System.out.println("delete successfully");
            transaction.commit();

        } catch (NullPointerException mess) {

            System.out.println("The value if you need is null "+mess);

        } finally {

            try {

                if(session != null) {
                    session.close();
                }

            } catch(Exception mess) {

                System.out.println("somethings is wrong..."+mess);

            }

        } /* finally */
    } /* end delete */

}
