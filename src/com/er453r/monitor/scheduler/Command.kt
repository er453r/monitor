package com.er453r.monitor.scheduler

class Command(val cmd:String, val args:Array<String> = arrayOf(), val timeout:Int = 5, val remote:Boolean = true)