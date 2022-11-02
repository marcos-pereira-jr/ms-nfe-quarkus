# NFE Brasil Import

Project that imports Brazilian nfe by code through the website of Ministerio da Fazenda

## Getting Started

This project uses Quarkus, the Supersonic Subatomic Java Framework.
If you want to learn more about Quarkus, please visit its website: https://quarkus.io/.

## Running the application in dev mode

You can run your application in dev mode that enables live coding using:
```shell script
./mvnw quarkus:dev
```
> **_NOTE:_**  Quarkus now ships with a Dev UI, which is available in dev mode only at http://localhost:8080/q/dev/.

## Usage

* Import NFE to ElastchSearch
    ```
    curl --location --request POST 'http://localhost:8080/v1/import' \
    --header 'Content-Type: application/json' \
    --data-raw '{
        "code" : "1221111111111111"
    }'
    ```

## Deployment

Additional notes on how to deploy this on a live or release system. Explaining the most important branches, what pipelines they trigger and how to update the database (if anything special).

## Additional Documentation and Acknowledgments

------
