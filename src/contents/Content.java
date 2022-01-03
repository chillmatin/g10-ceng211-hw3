package contents;

public abstract class Content implements Comparable<Object>, Cloneable{
    private int arrivalDay;
    private int contentCode;
    private String name;
    private double avgRating;

    public Content(int arrivalDay, int contentCode, String name, double avgRating) {
        setArrivalDay(arrivalDay);
        setContentCode(contentCode);
        setName(name);
        setAvgRating(avgRating);
    }

    public Content(String arrivalDay, String contentCode, String name, String avgRating) {
        setArrivalDay(arrivalDay);
        setContentCode(contentCode);
        setName(name);
        setAvgRating(avgRating);
    }

    public Content(Content content){
        setArrivalDay(content.getArrivalDay());
        setContentCode(content.getContentCode());
        setName(content.getName());
        setAvgRating(content.getAvgRating());
    }

    public Content(){
        setArrivalDay(-1);
        setContentCode(-1);
        setName("No name");
        setAvgRating(-1);
    }

    public int getArrivalDay() {
        return arrivalDay;
    }

    private void setArrivalDay(int arrivalDay) {
        this.arrivalDay = arrivalDay;
    }
    private void setArrivalDay(String arrivalDay){
        setArrivalDay(Integer.parseInt(arrivalDay));
    }

    public int getContentCode() {
        return contentCode;
    }

    private void setContentCode(int contentCode) {
        this.contentCode = contentCode;
    }

    private void setContentCode(String contentCode){
        setContentCode(Integer.parseInt(contentCode));
    }


    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public double getAvgRating() {
        return avgRating;
    }

    private void setAvgRating(double avgRating) {
        this.avgRating = avgRating;
    }

    private void setAvgRating(String avgRating){
        setAvgRating(Double.parseDouble(avgRating));
    }

    /**
     * Lexicographically compares content's name with another Content object's name.
     * @param o Content object
     * @return negative value if this.name lexicographically comes before the name of the o object
     *         0 if names are the same
     *         positive value if this.name is lexicographically comes after the name of the o object.
     */
    @Override
    public int compareTo(Object o) {

        if (o == null){
            System.out.println("Content Class: Null object is not comparable");
            System.exit(0);
        }else if(!(o instanceof Content)){
            System.out.println("Content Class: Unmatching object type. Object o is " + o.getClass().toString());
            System.exit(0);
        }

        Content other = (Content) o;
        return name.compareTo(other.getName());
    }


    /**
     * It returns a copied object of the content
     * @return An instance of Content class
     */
    @Override
    public abstract Content clone();
}
