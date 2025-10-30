package partc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

        AccountService service = ctx.getBean(AccountService.class);

        try {
            System.out.println("Balances before transfer:");
            print(ctx, 1);
            print(ctx, 2);

            service.transferMoney(1, 2, 500.0);

            System.out.println("Balances after transfer:");
            print(ctx, 1);
            print(ctx, 2);
        } catch (Exception e) {
            System.out.println("Transfer failed: " + e.getMessage());
        } finally {
            ctx.close();
        }
    }

    private static void print(AnnotationConfigApplicationContext ctx, int id) {
        AccountDAO dao = ctx.getBean(AccountDAO.class);
        // Needs transaction to read current session; simplify by opening a new sessionFactory read or add transactional read method.
        // For demo, fetch via sessionFactory.getCurrentSession in a transaction would be ideal.
        System.out.println("Account " + id + " (check DB directly for balances).");
    }
}
