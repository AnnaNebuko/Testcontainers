package com.example.testcontainers.containers;

import org.testcontainers.containers.PostgreSQLContainer;

public class PostgresTestContainer extends PostgreSQLContainer<PostgresTestContainer> {

  public static final String IMAGE_VERSION = "postgres:14.3-alpine";
  public static final String DATABASE_NAME = "test";
  public static PostgresTestContainer container;

  public PostgresTestContainer() {
    super(IMAGE_VERSION);
  }

  public static PostgresTestContainer getInstance() {
    if (container == null) {
      container = new PostgresTestContainer().withDatabaseName(DATABASE_NAME);
    }
    return container;
  }

  @Override
  public void start() {
    super.start();
    System.setProperty("jdbc:postgresql://localhost:5432/etesting", container.getJdbcUrl());
    System.setProperty("postgres", container.getUsername());
    System.setProperty("postgres", container.getPassword());
  }

  @Override
  public void stop() {
  }
}
