package hellojpa.mapping;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();
        try {
            Member member = new Member();
            member.setUsername("C");

            System.out.println("================");
            em.persist(member);
            System.out.println("member.id = " + member.getId());
            System.out.println("================");
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        // 프로그램이 종료될 때 닫아줘야한다.
        emf.close();
    }
}
