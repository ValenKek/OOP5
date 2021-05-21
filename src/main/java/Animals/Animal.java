package Animals;


import Behaviors.Behaviors;

import java.util.Date;

public class Animal {

    int id;
    int behaviorId;
    int cost;
    String name;
    Date date;
    Behaviors behavior;

    public Animal(){
        date = new Date();
    }
    public Animal(int id, int behaviorId, int cost, String name) {
        this.id = id;
        this.behaviorId = behaviorId;
        this.cost = cost;
        this.name = name;
        date = new Date();
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

    public int getBehaviorId() {
        return behaviorId;
    }

    public void setBehaviorId(int behaviorId) {
        this.behaviorId = behaviorId;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Behaviors getBehavior() {
        return behavior;
    }

    public void setBehavior(Behaviors behavior) {
        this.behavior = behavior;
    }

    public Animal(int behavior, int cost, String name) {
        this.name = name;
        this.behaviorId = behavior;
        this.cost = cost;
        date = new Date();
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", behaviorId=" + behaviorId +
                ", cost=" + cost +
                ", name='" + name + '\'' +
                ", behavior=" + behavior +
                '}';
    }
}
