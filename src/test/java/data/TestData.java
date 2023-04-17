package data;

import java.time.LocalDateTime;
import java.util.Objects;

public class TestData {
    String send;
    String id;
    LocalDateTime date;
    String status;

    public TestData(String send, String id, LocalDateTime date, String status) {
        this.send = send;
        this.id = id;
        this. date = date;
        this.status = status;
    }
    public String getSend() {
        return send;
    }

    public void getSend(String send) {
        this.send = send;
    }


    public void setId(String id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "data.TestData{" +
                "send='" + send + '\'' +
                ", id='" + id + '\'' +
                ", date=" + date +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestData logLine = (TestData) o;
        return id.equals(logLine.id) &&
                Objects.equals(send, logLine.send) &&
                Objects.equals(status, logLine.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
