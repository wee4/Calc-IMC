package com.example.wesle.calcimc

enum class HealthState : IInfos{

    SEVERE_EMACIATION {
        override fun getRating() = 1
        override fun getMessage() = "Magreza severa"
    },
    MODERATE_LEANNESS {
        override fun getRating() = 2
        override fun getMessage() = "Magreza moderada"
    },
    LIGHTNESS {
        override fun getRating() = 3
        override fun getMessage() = "Magreza leve"
    },
    NORMALLY {
        override fun getRating() = 5
        override fun getMessage() = "Peso ideal"
    },
    OVERWEIGHT {
        override fun getRating() = 4
        override fun getMessage() = "Excesso de peso"
    },
    PRE_OBESITY {
        override fun getRating() = 3
        override fun getMessage() = "Pré Obeso"
    },
    OBESE {
        override fun getRating() = 2
        override fun getMessage() = "Obeso"
    },
    OBESE_2 {
        override fun getRating() = 1
        override fun getMessage() = "Obesidade Grau II"
    },
    OBESE_3 {
        override fun getRating() = 1
        override fun getMessage() = "Obesidade Grau III"
    },
    UNKNOWN{
        override fun getRating() = 0
        override fun getMessage() = "Erro"
    }
}