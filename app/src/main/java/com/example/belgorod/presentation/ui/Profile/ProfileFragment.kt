package com.example.belgorod.presentation.ui.Profile

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.belgorod.APP_PREFERENCES
import com.example.belgorod.CASH
import com.example.belgorod.R
import com.example.belgorod.databinding.FragmentProfileBinding
import com.example.belgorod.presentation.module.PersonalInfo
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*


class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        val binding = FragmentProfileBinding.inflate(inflater, container, false)

        val person = PersonalInfo(
            personImage = "https://sun9-37.userapi.com/impg/F2Mcv5U5c-bYCIro5A2JbaZXYX3nBw_MW9WE6A/13Y4URmi50c.jpg?size=640x640&quality=96&sign=66e96e35471dcfcbdbe732a60ba6ffa9&type=album",
            numberRespondents = 2,
            rating = 4.5F,
            name = "Марченко Дмитрий Андреевич",
            about_myself = "Студент программист. Весёлый и жизнерадостный. Жизнь настолько уникально что даже не знаю что ещё тут писать",
            city = "Белгород, Белгородская область, Российская Федерация",
            birthday = LocalDate.of(2001,8,19),
            achievement = "",
            smoking = "Крайне негативно",
            alchocol = "Негативно",
            telephon = "8(915)5227893"
        )
        Glide.with(requireContext())
            .load(person.personImage)
            .fitCenter()
            .placeholder(R.drawable.no_image)
            .error(R.drawable.no_image)
            .into(binding.image)

        binding.name.text = person.name

        var rating = person.rating
        for (i in 1..5)
        {
            val id = resources.getIdentifier("image"+i.toString(),"id",requireContext().opPackageName)
            binding.root.findViewById<ImageView>(id).let{image->
                if(rating>=1f){
                    image.setImageResource(R.drawable.starfill)
                    rating -= 1f
                }
                else
                {
                    image.setImageResource(R.drawable.star)
                }
            }

        }
        val shared = activity?.getSharedPreferences(APP_PREFERENCES, Context.MODE_PRIVATE)
        binding.cash.text = "${shared?.getInt(CASH,10000).toString()} баллов"


        binding.aboutMyselt.text = person.about_myself
        var birthday_text =
            "${translateMonthToString(person.birthday.monthValue)}, ${person.birthday.dayOfMonth.toString()} " +
                    "${person.birthday.year.toString()} "
        val today = LocalDate.now()
        var age = today.year - person.birthday.year
        if (today.monthValue - person.birthday.monthValue<=0){
            when (today.monthValue - person.birthday.monthValue){
                0 -> {
                    if (today.dayOfMonth - person.birthday.dayOfMonth < 0){
                        age -= 1
                    }
                }
                else -> age -= 1
            }
        }
        val ageText: String
        if (age%10 >= 5 || age%10 == 0)
            ageText = "(${age} лет)"
        else{
            if (age%1 > 1){
                ageText = "(${age} года)"
            }
            else{
                ageText = "(${age} год)"
            }
        }
        birthday_text += ageText
        binding.birthday.text = birthday_text
        binding.achievements.text = person.achievement
        binding.attitudeToSmoking.text = person.smoking
        binding.attitudeToAlcohol.text = person.alchocol
        binding.city.text = person.city
        binding.telephone.text = person.telephon

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    @SuppressLint("SimpleDateFormat")
    fun translateMonthToString(monthNum: Int): String {
        val dateParser = SimpleDateFormat("MM")
        val date = dateParser.parse(monthNum.toString())
        val dateFormatter = date?.let { SimpleDateFormat("LLLL", Locale("ru")).format(it) }
        return (dateFormatter.toString().replaceFirstChar { it.titlecase(Locale.getDefault()) })
    }

}