public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        DependencyInjector injector = new DependencyInjector();
        injector.register(UserService.class, new UserService());

        UserController userController = new UserController();
        injector.injectDependencies(userController);

        userController.handleRequest();
    }
}
