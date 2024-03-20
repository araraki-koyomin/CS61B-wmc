import java.math.*;

public class Planet {
    public static final double G = 6.67e-11;
    double xxPos, yyPos, xxVel, yyVel, mass;
    String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet other) {
        double xDis = other.xxPos - this.xxPos;
        double yDis = other.yyPos - this.yyPos;
        return Math.sqrt(xDis * xDis + yDis * yDis);
    }

    public double calcForceExertedBy(Planet other) {
        double dis = calcDistance(other);
        return G * this.mass * other.mass / (dis * dis);
    }

    public double calcForceExertedByX(Planet other) {
        double xDis = other.xxPos - this.xxPos;
        double dis = calcDistance(other);
        double force = calcForceExertedBy(other);
        if (xDis > 0) {
            return xDis / dis * force;
        } else if(xDis < 0) {
            return -(xDis / dis) * force;
        } else {
            return 0;
        }
    }

    public double calcForceExertedByY(Planet other) {
        double yDis = other.yyPos - this.yyPos;
        double dis = calcDistance(other);
        double force = calcForceExertedBy(other);
        if (yDis > 0) {
            return yDis / dis * force;
        } else if (yDis < 0) {
            return -(yDis / dis) * force;
        } else {
            return 0;
        }
    }

    public boolean equals(Planet other) {
        return this == other;
    }
    public double calcNetForceExertedByX(Planet[] planets) {
        double netForceExertedX = 0;
        for (Planet planet: planets) {
            if (equals(planet)) {
                continue;
            }
            int direction = planet.xxPos - this.xxPos > 0 ? 1 : -1;
            netForceExertedX += direction * calcForceExertedByX(planet);
        }
        return netForceExertedX;
    }

    public double calcNetForceExertedByY(Planet[] planets) {
        double netForceExertedY = 0;
        for (Planet planet: planets) {
            if (equals(planet)) {
                continue;
            }
            int direction = planet.yyPos - this.yyPos > 0 ? 1 : -1;
            netForceExertedY += direction * calcForceExertedByY(planet);
        }
        return netForceExertedY;
    }

    public void update(double dt, double fX, double fY) {
        xxVel = xxVel + dt * fX / mass;
        yyVel = yyVel + dt * fY / mass;
        xxPos = xxPos + dt * xxVel;
        yyPos = yyPos + dt * yyVel;
    }

    public void draw(){
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
