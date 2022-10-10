package ru.geekbrains.oop05.mvp.homework.calculator;


public class Presenter {

    private final UsualModel model;

    private final View view;


    public Presenter(UsualModel model, View view) {
        this.model = model;
        this.view = view;
    }

    public void execute() {
        int operator;
        model.setFirst(view.getValue("Enter first number: "));
        model.setSecond(view.getValue("Enter second number: "));
        for (int i = 0; i < model.getOperations().size(); i++) {
            System.out.printf("for %c input %d\n", model.getOperations().get(i), i);
        }
        extracted();
    }

    private void extracted() {
        int operator;
        operator = view.getValue("Enter number: ");
        if (operator == 0) {
            view.print("Sum is " + model.getSum());
        } else if (operator == 1) {
            view.print("Diff is " + model.getDiff());
        } else if (operator == 2) {
            view.print("Div is " + model.getDiv());
        } else if (operator == 3) {
            view.print("Multiply is " + model.getMultiplication());
        } else {
            throw new AssertionError("operation not found");
        }
    }

    private static class MockView implements View {

        private int count = 0;

        @Override
        public int getValue(String message) {
            count++;
            return 1;
        }

        @Override
        public void print(String message) {
            if (!message.equals("Sum is 2")) {
                throw new AssertionError("Incorrect sum");
            }
        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        UsualModel usualModel = new UsualModel();
        MockView mockView = new MockView();
        Presenter presenter = new Presenter(usualModel, mockView);

        presenter.execute();
        if (mockView.getCount() != 2) {
            throw new AssertionError("Incorrect call of getValue()");
        }
    }
}
