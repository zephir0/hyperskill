class Circle {

    double radius;

    // write methods here
    public double getLength() {
        return 2 * Math.PI * this.radius;
    }

    public double getArea() {
        return Math.PI * (this.radius * this.radius);
    }
}