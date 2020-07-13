package Bean;

import java.io.Serializable;

public class Product implements Serializable{
	private int id;
	private String name;
	private double value;
	private int left_number;
	private String message;
	private String image_src;
	private Type type;
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public int getLeft_number() {
		return left_number;
	}
	public void setLeft_number(int left_number) {
		this.left_number = left_number;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getImage_src() {
		return image_src;
	}
	public void setImage_src(String image_src) {
		this.image_src = image_src;
	}
	
}
