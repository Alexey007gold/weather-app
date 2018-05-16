Feature: Clothing recommendation according to current weather
    As a anonymous or logged in user
    I want to get clothing recommendations for selected day
    Because I want to plan my day accordingly

    Scenario Outline: Define clothes suitable for certain weather
        Given I have weather clothing rule book that has neutral temperature lower bound 12 and upper bound 20
        When Weather rule book defines clothes for fact with code <weatherCode> and temperature <temperature>
        Then Expect that clothes list contains "<expectedClothes>"

          Examples:
            | weatherCode | temperature |                  expectedClothes                        |
            |     200     |     22.0      |   Umbrella, Jacket, Light pants, Boots                |
            |     200     |     15.0      |   Umbrella, Jacket, Light pants, Boots                |
            |     200     |      5.0      |   Umbrella, Jacket, Warm pants, Boots                 |
            |     300     |     20.0      |   Umbrella, Jacket, Light pants, Boots                |
            |     300     |     13.0      |   Umbrella, Jacket, Light pants, Boots                |
            |     300     |     -5.0      |   Umbrella, Jacket, Warm pants, Boots                 |
            |     500     |      0.0      |   Umbrella, Beanie, Winter jacket, Warm pants, Boots  |
            |     500     |     16.0      |   Umbrella, Jacket, Light pants, Boots                |
            |     500     |     21.0      |   Umbrella, Jacket, Light pants, Boots                |
            |     600     |    -15.0      |   Beanie, Scarf, Winter jacket, Warm Pants, Boots     |
            |     600     |     17.0      |   Scarf, Jacket, Warm Pants, Boots                    |
            |     700     |    -20.0      |   Beanie, Scarf, Winter jacket, Warm Pants, Boots     |
            |     700     |     12.0      |   Scarf, Jacket, Warm Pants, Boots                    |
            |     700     |     26.0      |   Panama hat, Sunglasses, T-Shirt, Shorts, Sneakers   |
            |     800     |     -3.0      |   Beanie, Scarf, Winter Jacket, Warm Pants, Boots     |
            |     800     |     17.0      |   Scarf, Jacket, Light Pants, Boots                   |
            |     800     |     28.0      |   Baseball hat, Sunglasses, T-Shirt, Shorts, Sandals  |