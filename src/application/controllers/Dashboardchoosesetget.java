package application.controllers;

public class Dashboardchoosesetget {
private String chooser;
public Dashboardchoosesetget(String chooser) {
	this.chooser=new String(chooser);
}
public String getChooser() {
	return chooser;
}
public void setChooser(String chooser) {
	this.chooser = chooser;
}
@Override
public String toString() {
	return this.getChooser();
}
}
