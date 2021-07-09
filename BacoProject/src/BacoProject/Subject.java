package BacoProject;
import BacoProject.Demacia.Observer;

public interface Subject {
    void Attach(Observer o);
    void Dettach(Observer o);
    void Notify();
}
