package com.example.myapplication.user

import com.example.myapplication.umbrella.IWeather

class StubWeather: IWeather
{
    var fakeIsSunny = false
    override fun isSunny(): Boolean {
        return fakeIsSunny
    }
}