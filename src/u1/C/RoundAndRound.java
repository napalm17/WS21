package u1.C;

public class RoundAndRound {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        circle1.radius = 5.1;

        // calculate the remaining attributes for circle1 here
        circle1.diameter = circle1.radius * 2;
        circle1.circumference = circle1.diameter * Math.PI;
        circle1.area = Math.pow(circle1.radius, 2) * Math.PI;

        Circle circle2 = new Circle();
        circle2.radius = 17.5;

        // calculate the remaining attributes for circle2 here
        circle2.diameter = circle2.radius * 2;
        circle2.circumference = circle2.diameter * Math.PI;
        circle2.area = Math.pow(circle2.radius, 2) * Math.PI;

        // add more output-commands here

        System.out.println("circle1.radius = " + circle1.radius);
        System.out.println("circle1.diameter = " + circle1.diameter);
        System.out.println("circle1.circumference = " + circle1.circumference);
        System.out.println("circle1.area = " + circle1.area + "\n");

        System.out.println("circle2.radius = " + circle2.radius);
        System.out.println("circle2.diameter = " + circle2.diameter);
        System.out.println("circle2.circumference = " + circle2.circumference);
        System.out.println("circle2.area = " + circle2.area + "\n");

        // attributes of cone1
        Cone cone1 = new Cone();
        cone1.height = 10.3;
        cone1.base = circle1;
        cone1.volume = cone1.base.area * cone1.height / 3;
        cone1.surfaceArea = cone1.base.area +
                Math.PI * cone1.base.radius * Math.sqrt(Math.pow(cone1.base.radius, 2) + Math.pow(cone1.height, 2)); // Area of the lateral surface is calculated with the formula pi * radius * slant.
                                                                                                                    // Length of the slant is calculated with the pythagorean formula: slant^2 = radius^2 + height^2
        // attributes of cone2
        Cone cone2 = new Cone();
        cone2.height = 10.3;
        cone2.base = circle2;
        cone2.volume = cone2.base.area * cone2.height / 3;
        cone2.surfaceArea = cone2.base.area +
                Math.PI * cone2.base.radius * Math.sqrt(Math.pow(cone2.base.radius, 2) + Math.pow(cone2.height, 2));

        // output commands
        System.out.println("cone1.height = " + cone1.height);
        System.out.println("cone1.base.area = " + cone1.base.area);
        System.out.println("cone1.volume = " + cone1.volume);
        System.out.println("cone1.surfaceArea = " + cone1.surfaceArea + "\n");

        System.out.println("cone2.height = " + cone2.height);
        System.out.println("cone2.base.area = " + cone2.base.area);
        System.out.println("cone2.volume = " + cone2.volume);
        System.out.println("cone2.surfaceArea = " + cone2.surfaceArea);

    }
}
