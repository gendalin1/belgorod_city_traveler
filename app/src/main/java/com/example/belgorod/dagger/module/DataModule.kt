package com.example.belgorod.dagger.module

import dagger.Module

@Module(includes = [NetworkModule::class, DataBindsModule::class, LocalDBModule::class])
class DataModule