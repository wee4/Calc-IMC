package com.example.wesle.calcimc

class CalculationsUtils {
    companion object {
        fun analyse(IMC : Double, isWoman: Boolean, activityType : Int) : HealthState{

            if(IMC >= 40){ return HealthState.OBESE_3 }

            if(IMC in 35..39){ return HealthState.OBESE_2 }

            if(IMC in 30..35){return HealthState.OBESE}

            if(IMC in 27.50..29.99) {return HealthState.PRE_OBESITY }

            if(IMC in 25.00..27.49) {return HealthState.OVERWEIGHT }

            if(IMC in 18.50..24.99) {return HealthState.NORMALLY }

            if(IMC in 17.00..18.49) {return HealthState.LIGHTNESS }

            if(IMC in 16.00..16.99) {return HealthState.MODERATE_LEANNESS }

            if(IMC < 16.00) {return HealthState.SEVERE_EMACIATION  }

            return HealthState.UNKNOWN
        }
    }

}