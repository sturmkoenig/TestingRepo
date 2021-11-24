FROM airhacks/glassfish
COPY ./target/SQLConnectionTest.war ${DEPLOYMENT_DIR}
