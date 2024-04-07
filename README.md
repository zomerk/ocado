# Basket Splitter

Basket Splitter is a Java application designed to split a list of items into delivery packages based on a configured mapping. It aims to facilitate the distribution of items according to predefined delivery options.

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

To run this project, you need:

- Java Development Kit (JDK) installed on your machine
- IDE (such as IntelliJ IDEA, Eclipse, etc.) for Java development

### Installation

1. Clone the repository to your local machine:

```
git clone https://github.com/zomerk/ocado.git
```

2. Open the project in your preferred IDE.

3. Ensure that the required dependencies are resolved.

### Configuration

The application requires a configuration file specifying the mapping of products to delivery options. The configuration file should be in JSON format.

Example configuration file (`config.json`):

```json
{
  "Fond - Chocolate": ["Option1", "Option2"],
  "Chocolate - Unsweetened": ["Option2"],
  "Nut - Almond, Blanched, Whole": ["Option1"],
  ...
}
```

### Usage

1. Modify the `Main` class to specify the absolute path to your configuration file.

2. Define the list of items to be split into delivery packages in the `main` method of the `Main` class.

3. Run the `Main` class to see the split delivery packages.
