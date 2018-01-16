# Generated by Django 2.0.1 on 2018-01-13 17:57

from django.db import migrations, models
import django.db.models.deletion


class Migration(migrations.Migration):

    initial = True

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Pizza',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=60)),
                ('price_small', models.DecimalField(decimal_places=2, max_digits=8)),
                ('price_big', models.DecimalField(decimal_places=2, max_digits=8)),
                ('description', models.TextField(null=True)),
            ],
        ),
        migrations.CreateModel(
            name='PizzaTopping',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('pizza', models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='main.Pizza')),
            ],
        ),
        migrations.CreateModel(
            name='Topping',
            fields=[
                ('id', models.AutoField(auto_created=True, primary_key=True, serialize=False, verbose_name='ID')),
                ('name', models.CharField(max_length=60)),
                ('on_top_of', models.ManyToManyField(through='main.PizzaTopping', to='main.Pizza')),
            ],
        ),
        migrations.AddField(
            model_name='pizzatopping',
            name='topping',
            field=models.ForeignKey(on_delete=django.db.models.deletion.PROTECT, to='main.Topping'),
        ),
        migrations.AddField(
            model_name='pizza',
            name='toppings',
            field=models.ManyToManyField(through='main.PizzaTopping', to='main.Topping'),
        ),
    ]