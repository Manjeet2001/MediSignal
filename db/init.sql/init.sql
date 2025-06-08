
CREATE TABLE patients (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender VARCHAR(10) NOT NULL,
    contact VARCHAR(100) NOT NULL
);

CREATE TABLE subscriptions (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL,
    subscriber_email VARCHAR(100) NOT NULL,
    alert_types VARCHAR(100)[] NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients (id)
);

CREATE TABLE thresholds (
    id SERIAL PRIMARY KEY,
    subscription_id INT NOT NULL,
    alert_type VARCHAR(50) NOT NULL,
    min_value INT,
    max_value INT,
    systolic INT,
    diastolic INT,
    FOREIGN KEY (subscription_id) REFERENCES subscriptions (id)
);

CREATE TABLE health_data (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    heart_rate INT,
    systolic INT,
    diastolic INT,
    FOREIGN KEY (patient_id) REFERENCES patients (id)
);

CREATE TABLE alerts (
    id SERIAL PRIMARY KEY,
    patient_id INT NOT NULL,
    type VARCHAR(50) NOT NULL,
    value INT NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    delivery_method VARCHAR(50) NOT NULL,
    FOREIGN KEY (patient_id) REFERENCES patients (id)
);

CREATE TABLE delivery_logs (
    id SERIAL PRIMARY KEY,
    alert_id INT NOT NULL,
    attempt INT NOT NULL,
    timestamp TIMESTAMP NOT NULL,
    status VARCHAR(50) NOT NULL,
    method VARCHAR(50) NOT NULL,
    response_code INT,
    FOREIGN KEY (alert_id) REFERENCES alerts (id)
);
